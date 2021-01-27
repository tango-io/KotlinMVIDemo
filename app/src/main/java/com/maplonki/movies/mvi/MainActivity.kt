package com.maplonki.movies.mvi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maplonki.movies.mvi.grid.view.MovieGridFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.activity_container, MovieGridFragment())
            .commit()
    }
}