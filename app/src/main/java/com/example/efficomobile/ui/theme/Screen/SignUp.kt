package com.example.efficomobile.ui.theme.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp() {

    val navController = rememberNavController()

    var emailTextFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    var passwordTextFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold() {
        Column(modifier = Modifier.padding(it)) {
            TextField(
                value = emailTextFieldValue,
                onValueChange = { emailTextFieldValue = it },
                label = { Text(text = "Email") },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            TextField(
                value = passwordTextFieldValue,
                onValueChange = { passwordTextFieldValue = it },
                label = { Text(text = "Mot de passe") },
                visualTransformation = PasswordVisualTransformation(),
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Button(
                onClick = {
                    val email = emailTextFieldValue.text
                    val password = passwordTextFieldValue.text

                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    // L'utilisateur s'est connecté avec succès
                                    navController.navigate("Home") // Remplacez "Home" par l'ID de votre destination "Home" dans nav_graph.xml
                                } else {
                                    try {
                                        throw task.exception!!
                                    } catch (e: FirebaseAuthInvalidUserException) {
                                        // L'utilisateur n'existe pas
                                    } catch (e: FirebaseAuthInvalidCredentialsException) {
                                        // Mot de passe incorrect
                                    } catch (e: Exception) {
                                        // Autres erreurs
                                    }
                                }
                            }
                    } else {
                        // afficher un message demandant de remplir les champs vides
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Enregistrer")
            }
        }
    }
}
