package id.alfaridzi.dicodingsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvReceipt: RecyclerView
    private var list: ArrayList<Receipt> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Home"

        rvReceipt = findViewById(R.id.rv_receipt)
        rvReceipt.setHasFixedSize(true)

        list.addAll(ReceiptData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvReceipt.layoutManager = LinearLayoutManager(this)
        val listReceiptAdapter = ListReceiptAdapter(list)
        rvReceipt.adapter = listReceiptAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(iAbout)
            }
        }
    }
}
