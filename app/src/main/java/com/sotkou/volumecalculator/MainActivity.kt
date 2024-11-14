package com.sotkou.volumecalculator

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Το View
        val gridView: GridView = findViewById(R.id.gridView)

        // Data Source
        var sphere:Shape = Shape("Sphere", R.drawable.sphere)
        var cuboid:Shape = Shape("Cuboid", R.drawable.cuboid)
        var cylinder:Shape = Shape("Cylinder", R.drawable.cylinder)
        var cube:Shape = Shape("Cube", R.drawable.cube)

        val shapeList = listOf<Shape>(sphere,cube,cuboid,cylinder)

        // Ο Adapter
        val customAdapter = MyCustomAdapter(this,shapeList)

        // Σύνδεση adapter με gridView
        gridView.adapter = customAdapter

        // Χειρισμός των κλικ
        // Η πρώτη, δεύτερη και τέταρτη παράμετρος θα παραλειφθούν με _ χαρακτήρα.
        // Θα χρησιμοποιήσουμε μόνο την παράμετρο position
        // Η position ειναι η θέση του gridView στην οποία έγινε το κλικ.

        gridView.setOnItemClickListener { _, _, position, _ ->
            val clickedItem = customAdapter.getItem(position)

            if (clickedItem?.shapeName.equals("Sphere")){
                var intent = Intent (this, SphereActivity::class.java)
                startActivity(intent)
            }
        }
    }
}