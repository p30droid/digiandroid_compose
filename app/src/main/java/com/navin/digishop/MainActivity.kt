package com.navin.digishop

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.provider.MediaStore.Images
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.navin.digishop.navigation.Nav
import com.navin.digishop.screens.DashboardScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                //  color = MaterialTheme.colorScheme.background
            ) {
                //Greeting("Android")
                //hello()
                // HomeScreen()

                // Nav()

                DashboardScreen()


            }
        }
    }
}

@Composable
fun hello() {
    val activity = LocalContext.current as Activity

   Column(modifier = Modifier
       .fillMaxHeight()
       .fillMaxWidth() , verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally
       ) {
       Button(onClick = {
        Toast.makeText(activity , "Login user", Toast.LENGTH_LONG).show()

       }) {
           Text(text ="Login")
       }

       OutlinedButton(onClick = { /*TODO*/ }) {
           Row(modifier = Modifier.padding(8.dp)) {
                Image(painter = painterResource(id = R.drawable.baseline_login_24),
                    contentDescription = "")
               Text(text = "Login")
           }
       }

   }

}

@Composable
fun ProfileCard(modifier: Modifier = Modifier) {


    var counter : MutableState<Int> = remember {
        mutableStateOf(0)
    }

    var displayAlert : MutableState<Boolean> = remember {
        mutableStateOf(false)
    }


    var myArray : MutableList<String> = arrayListOf()

    myArray.add("Hasehm zade interface")
    myArray.add("MirAhmadi TextView")
    myArray.add("Sayyad ViewHolder")
    myArray.add("Shams Gone")
    myArray.add("Ansari MVP")
    myArray.add("Rahnavard MVVM")
    myArray.add("Babaei Dark Mode")
    myArray.add("Bahrami Sooti")



    Card(modifier = Modifier.fillMaxWidth()) {
        
        Column {
            
            Image(painter = painterResource(id = R.drawable.digikala), contentDescription = "" ,
                modifier = modifier)

            LazyRow(){
                items(myArray) {app->
                    Card {
                        Text(app)
                    }
                }

            }


            Button(onClick = {

                counter.value++;
                Log.e("counter","$counter")

            }) {
                Text(text = "Click")
            }

            Text(text = "counter is ${counter.value} ")

            Button(onClick = {

                counter.value--;
                Log.e("counter","$counter")

            }) {
                Text(text = "Click")
            }

            Button(onClick = {


                displayAlert.value = true


            }) {
                Text("About Us")
            }

             if(displayAlert.value)
            AlertDialog(onDismissRequest = {
               // displayAlert.value=false
            }, confirmButton = { Button(onClick = { /*TODO*/ }) {
                Text(text = "Yes")
            } } ,

                title = { Text("Welcome") } , dismissButton = {
                    Button(onClick = {

                        displayAlert.value=false

                    }) {
                        Text(text = "Close")
                    }
                })




        }
        

        

    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
 @Composable
fun HomeScreen2() {
     Scaffold(
        topBar = { TopAppBar(title = {Text("TopAppBar" , color = Color.Blue)}  ) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = {
            
        }){
            Text("X")
        } },
        content = {  ProfileCard(modifier = Modifier
            .height(150.dp)
            .width(150.dp)) },
        bottomBar = { BottomAppBar() { Text("BottomAppBar") } }
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DashboardScreen()
}