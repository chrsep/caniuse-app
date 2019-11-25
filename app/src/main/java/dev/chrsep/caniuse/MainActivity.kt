package dev.chrsep.caniuse

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import dev.chrsep.caniuse.databinding.ActivityMainBinding

class MainActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContent {
//            MaterialTheme {
//                Greeting("Android")
//            }
//        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Card(color = Color.White) {
//        Padding(padding = Dp(16f)) {
//            Text(text = "Hello $name!")
//        }
//    }
//}
//
//@Preview
//@Composable
//fun DefaultPreview() {
//    MaterialTheme {
//        Greeting("Android")
//    }
//}
