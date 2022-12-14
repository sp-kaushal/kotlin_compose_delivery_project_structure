package com.example.deliveryprojectstructuredemo.ui.features.login

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.deliveryprojectstructuredemo.R
import com.example.deliveryprojectstructuredemo.common.Route
import com.example.deliveryprojectstructuredemo.ui.features.components.AppButton
import com.example.deliveryprojectstructuredemo.ui.features.components.AppOutlineTextField
import com.example.deliveryprojectstructuredemo.ui.features.components.AppText
import com.example.deliveryprojectstructuredemo.ui.features.components.SocialSection
import com.example.deliveryprojectstructuredemo.ui.theme.DeliveryProjectStructureDemoTheme
import com.example.deliveryprojectstructuredemo.ui.theme.spacing

/*

@Composable
fun LoginScreen(navController: NavController, vm: LoginViewModel = hiltViewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    val loginState = vm.uiState.collectAsState().value

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {

        when (loginState) {
            is LoginViewModel.UIState.SignedOut -> {
                LoginFields(
                    email,
                    password,
                    onLoginClick = {
                        vm.login(email, password)
                    },
                    onEmailChange = { email = it },
                    onPasswordChange = { password = it }
                )
            }
            is LoginViewModel.UIState.InProgress -> {
                CircularProgressIndicator()
            }

            is LoginViewModel.UIState.SignIn -> {
                Toast.makeText(
                    context,
                    "${loginState.userName} Signed in successfully",
                    Toast.LENGTH_SHORT
                ).show()
                navController.navigate(SIGN_UP_SCREEN)
            }

            is LoginViewModel.UIState.Error -> {
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoginFields(
    email: String,
    password: String,
    onLoginClick: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        //        verticalArrangement = Arrangement.spacedBy(25.dp),
//        verticalArrangement = Arrangement.spacedBy(LocalSpacing.current.medium),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppText("Please login", modifier = Modifier.background(color = MaterialTheme.colors.background))

        OutlinedTextField(
            value = email,
            label = { Text(text = "Mobile Number") },
            onValueChange = onEmailChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = password,
            label = { Text(text = "Password") },
            onValueChange = onPasswordChange,
            visualTransformation = PasswordVisualTransformation()
        )

        AppButton(onClick = {
            onLoginClick(email)
        }, modifier = Modifier.width(300.dp)) {
            Text("Login")
        }
    }
}*/
@Composable
fun LoginScreen(navController: NavController) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility: Boolean by rememberSaveable { mutableStateOf(false) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_login),
                contentDescription = "Login Icon",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            AppText(
                text = stringResource(id = R.string.log_in),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
            AppText(
                text = stringResource(id = R.string.enter_registered_emaila_and_pass),
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            AppOutlineTextField(
                value = email,
                label = { Text(text = stringResource(id = R.string.email)) },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    email = it
                },
                placeholder = { Text(text = stringResource(id = R.string.enter_your_email)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
            AppOutlineTextField(
                value = password,
                label = { Text(text = stringResource(id = R.string.password)) },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    password = it
                },
                placeholder = { Text(text = stringResource(id = R.string.your_password)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(
                            imageVector = if (passwordVisibility)
                                Icons.Filled.Visibility
                            else
                                Icons.Filled.VisibilityOff, ""
                        )
                    }
                })
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraSmall))
            AppText(
                text = stringResource(id = R.string.forgot_password),
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {

                    }
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            AppButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                androidx.compose.material.Text(text = stringResource(id = R.string.login))
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            SocialSection(
                headerText = stringResource(id = R.string.or_login_with),
                footerText1 = stringResource(id = R.string.dont_have_account),
                footerText2 = stringResource(id = R.string.create_now),
                onGoogleClick = { /*TODO*/ },
                onFacebookClick = { /*TODO*/ },
                onFooterClick = {navController.navigate(Route.SIGN_UP_SCREEN) })

        }

    }
}


@Preview("default", "rectangle")
@Preview("dark theme", "rectangle", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", "rectangle", fontScale = 2f)
@Composable
private fun RectangleButtonPreview() {
    DeliveryProjectStructureDemoTheme {
        Surface {
//            LoginScreen()
        }
    }
}