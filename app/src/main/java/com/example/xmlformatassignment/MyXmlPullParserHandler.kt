package com.example.xmlformatassignment

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream
import java.lang.Exception

class MyXmlPullParserHandler {
    private val studentsList = ArrayList<Student>()
    private var text: String? = null

    private var studentName = ""
    private var studentMarks = 0
    private var studentID = 0

    fun parse(inputStream: InputStream): List<Student> {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when(eventType){
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when{
                        tagName.equals("name", ignoreCase = true) -> { studentName = text.toString() }
                        tagName.equals("marks", ignoreCase = true) -> { studentMarks =
                            text?.toInt() ?: 0
                        }
                        tagName.equals("id", ignoreCase = true) -> { studentID =
                            text?.toInt() ?: 0
                        }
                            else -> { studentsList.add(Student(studentName,studentMarks,studentID))}
                    }
                    else -> {}
                }
                eventType = parser.next()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return studentsList
    }
}