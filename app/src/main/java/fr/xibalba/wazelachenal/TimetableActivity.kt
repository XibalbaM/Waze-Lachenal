package fr.xibalba.wazelachenal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.xibalba.pronoteKt.*
import fr.xibalba.wazelachenal.ui.theme.WazeLachenalTheme
import kotlinx.coroutines.runBlocking
import java.time.LocalDate

class TimetableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pronoteKt = PronoteKt("https://0740006e.index-education.net/pronote/", SessionType.STUDENT, Ent.AUVERGNE_RHONE_ALPES)
        runBlocking {
            pronoteKt.login(Credentials.username.value!!, Credentials.password.value!!)
            val courses = pronoteKt.getTimetable()[LocalDate.now().dayOfWeek.value].lessons.sortedBy { it.startingPosition }
            setContent {
                WazeLachenalTheme {
                    Column(modifier = Modifier.fillMaxSize()) {
                        for (course in courses) {
                            Course(course)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Course(course: Lesson) {
    Column {
        Text(text = course.subject)
        Text(text = course.teacher)
    }
}