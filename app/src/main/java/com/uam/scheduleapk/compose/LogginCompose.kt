package com.uam.scheduleapk.compose

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.uam.scheduleapk.R


@Composable
fun LoginCompose(modifier: Modifier) {
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }
    var passwordVisible by remember { mutableStateOf(false) }

    val context = LocalContext.current

    val image = if(passwordVisible)
                    painterResource(id = R.drawable.visibility)
                else
                        painterResource(id = R.drawable.visibility_off)

    Column (verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Image(painter = painterResource(id = R.drawable.messi), contentDescription = null)
        Spacer(modifier = Modifier.height(5.dp))
        TextField(value = email,
            onValueChange = {email = it},
            label = { Text(text = stringResource(id = R.string.email))}
        )
        Spacer(modifier = Modifier.height(5.dp))
        TextField(value = password,
            onValueChange = {password = it},
            label = {Text(text = stringResource(id = R.string.password))},
            visualTransformation = if(passwordVisible) VisualTransformation.None
                                    else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val description = if(passwordVisible) "Hide Password"
                                  else "Show Paswword"
                IconButton(onClick = {passwordVisible= !passwordVisible}) {
                    Icon(painter = image, contentDescription = description)
                }
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { Toast.makeText(context, "Entrar", Toast.LENGTH_LONG).show()}) {
            Text(text = stringResource(id = R.string.buttonLogin))
        }
    }
}

