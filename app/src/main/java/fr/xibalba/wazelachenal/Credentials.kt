package fr.xibalba.wazelachenal

import androidx.compose.runtime.mutableStateOf

object Credentials {

    val username = mutableStateOf<String?>(null)
    val password = mutableStateOf<String?>(null)
}