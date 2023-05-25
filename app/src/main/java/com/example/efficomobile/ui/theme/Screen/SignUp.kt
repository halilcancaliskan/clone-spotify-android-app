package com.example.efficomobile.ui.theme.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp() {

    val emailTextFieldValue = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val passwordTextFieldValue = remember {
        mutableStateOf(TextFieldValue(""))
    }

    Scaffold() {
        Column(modifier = Modifier.padding(it)) {

            TextField(
                value = emailTextFieldValue.value,
                onValueChange = { emailTextFieldValue.value = it },
                label = { Text(text = "Email") },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            TextField(
                value = passwordTextFieldValue.value,
                onValueChange = { passwordTextFieldValue.value = it },
                label = { Text(text = "Mot de passe") },
                visualTransformation = PasswordVisualTransformation(),
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Button(
                onClick = {
                    // Envoyer la requête d'inscription à Firebase avec les informations d'identification
                    val email = emailTextFieldValue.value.text
                    val password = passwordTextFieldValue.value.text


                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Enregistrer")
            }
        }
    }
}
