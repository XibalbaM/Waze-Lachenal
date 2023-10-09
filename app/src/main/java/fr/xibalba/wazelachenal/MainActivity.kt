package fr.xibalba.wazelachenal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import fr.xibalba.wazelachenal.ui.theme.WazeLachenalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WazeLachenalTheme {
                Column {
                    UsernameField()
                    PasswordField()
                    LoginButton()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsernameField() {
    OutlinedTextField(
        value = Credentials.username.value ?: "",
        onValueChange = { Credentials.username.value = it },
        label = { Text("Nom d'utilisateur") },
        placeholder = { Text("p.nomXX") }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField() {
    TextField(
        value = Credentials.password.value ?: "",
        onValueChange = { Credentials.password.value = it },
        label = { Text("Mot de passe") },
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun LoginButton() {
    val isValid = remember { mutableStateOf(true) }
    val context = LocalContext.current
    LaunchedEffect(Credentials.username.value, Credentials.password.value) {
        isValid.value = Credentials.username.value != null && Credentials.password.value != null
    }
    Button(onClick = {
        if (isValid.value) context.startActivity(Intent(context, TimetableActivity::class.java))
    }, enabled = isValid.value) {
        Text("Se connecter")
    }
}