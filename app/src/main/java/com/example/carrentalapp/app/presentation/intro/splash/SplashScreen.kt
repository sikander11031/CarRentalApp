package com.example.carrentalapp.app.presentation.intro.splash

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.carrentalapp.R
import com.example.carrentalapp.utils.Orientation
import com.example.carrentalapp.utils.addMoveAnimation
import network.chaintech.sdpcomposemultiplatform.sdp

@Composable
fun SplashScreen() {
    val appLogoMargin = 100.sdp
    val carLogoMargin = 35.sdp
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.splash_bg_color))
            .paint(
                painterResource(R.drawable.splashbg),
                contentScale = ContentScale.FillBounds,
                alpha = 0.03f
            )
    ) {
        val (logoCarRef, logoAppRef) = createRefs()


        Box(
            Modifier
                .wrapContentSize()
                .constrainAs(logoAppRef) {
                    top.linkTo(parent.top, margin = appLogoMargin)
                    start.linkTo(parent.start, margin = 65.dp)
                    end.linkTo(parent.end, margin = 65.dp)
                    width = Dimension.fillToConstraints
                }) {
            Image(
                painter = painterResource(R.drawable.chartercarlogo),
                contentDescription = "archaeological",
                modifier = Modifier
            )
        }
        Box(Modifier
            .wrapContentSize()
            .constrainAs(logoCarRef) {

                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom, margin = carLogoMargin)
                width = Dimension.fillToConstraints


            }
            .addMoveAnimation(
                from = (-300).dp,
                to = 0.dp,
                orientation = Orientation.Horizontal,
                duration = 900
            )

        ) {
            Image(
                painter = painterResource(R.drawable.carlogo),
                contentDescription = "CarLogo",
                modifier = Modifier

            )
        }

    }
}


@Composable
fun ImagePickerExample() {
    val context = LocalContext.current
    var selectedImageBitmap by remember { mutableStateOf<Bitmap?>(null) }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val imageUri: Uri? = data?.data
            if (imageUri != null) {
                selectedImageBitmap =
                    MediaStore.Images.Media.getBitmap(context.contentResolver, imageUri)
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
            }
            imagePickerLauncher.launch(intent)
        }) {
            Text("Choose Image")
        }

        selectedImageBitmap?.let { bitmap ->
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = "Selected Image"
            )
        }
    }
}
