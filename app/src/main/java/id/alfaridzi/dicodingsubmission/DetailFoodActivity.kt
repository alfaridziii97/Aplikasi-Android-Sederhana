package id.alfaridzi.dicodingsubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailFoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_receipt)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Makanan"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_set_name)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetIngredients: TextView = findViewById(R.id.tv_set_ingredients)
        val tvHowtomake: TextView = findViewById(R.id.tv_set_howtomake)
        val tvOrigin: TextView = findViewById(R.id.tv_item_origin)

        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getStringExtra(EXTRA_PHOTO)
        val tIngredients = intent.getStringExtra(EXTRA_INGREDIENTS)
        val tHowtomake = intent.getStringExtra(EXTRA_HOWTOMAKE)
        val tOrigin = intent.getStringExtra(EXTRA_ORIGIN)



        tvSetName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetIngredients.text = tIngredients
        tvHowtomake.text = tHowtomake
        tvOrigin.text = tOrigin
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_INGREDIENTS = "extra_ingredients"
        const val EXTRA_HOWTOMAKE = "extra_howtomake"
        const val EXTRA_ORIGIN = "extra_origin"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
