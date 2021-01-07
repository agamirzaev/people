package com.example.peoplelist

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.peoplelist.adapter.AdapterPeopleList
import com.example.peoplelist.data.model.Results
import com.example.peoplelist.mvp.peopleList.PeopleContract
import com.example.peoplelist.mvp.peopleList.PeoplePresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PeopleContract.View {

    private lateinit var results: ArrayList<Results?>

    private var isLoading: Boolean = true
    private var pastVisibleItem: Int = 0
    private var totalItemCount: Int = 0
    private var visbileItem: Int = 0
    private var previousItem: Int = 0
    private var viewThreshold: Int = 10

    private var pageNumber = 1

    private lateinit var toolbar: Toolbar

    private lateinit var presenter: PeoplePresenter

    private lateinit var adapterPeople: AdapterPeopleList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.titleToolbarMainActivity)

        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        recyclerUser!!.layoutManager = linearLayoutManager

        presenter = PeoplePresenter((application as App).dataManager!!)
        presenter.attachView(this)

        recyclerUser.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                visbileItem = linearLayoutManager.childCount
                totalItemCount = linearLayoutManager.itemCount
                pastVisibleItem = linearLayoutManager.findFirstVisibleItemPosition()

                if (dy > 0) {
                    if (isLoading && totalItemCount > previousItem) {
                        isLoading = false
                        previousItem = totalItemCount

                    }

//                    if (!isLoading) {
//                        if ((visbileItem + pastVisibleItem) >= totalItemCount && pastVisibleItem >= 0) {
//                            isLoading = true
//                            pageNumber++
//                            presenter.loadUser(pageNumber)
//                        }
//                    }
                    if (!isLoading && (totalItemCount - visbileItem) <= (pastVisibleItem + viewThreshold) && pageNumber < 10) {
                        isLoading = true
                        pageNumber++
                        presenter.loadUser(pageNumber)
                    }
                }
            }

        })

        presenter.loadUser(pageNumber)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)
        val item = menu!!.findItem(R.id.item_search)
        val searchView = item.actionView as android.widget.SearchView

        searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchUser(newText)
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    fun searchUser(search: String): String {
        if (search != "") {
            presenter.loadSearchUser(search)
        } else {
            presenter.loadUser(pageNumber)
        }
        return search
    }

    override fun showUsersPage(results: ArrayList<Results?>?) {
        adapterPeople.addData(results)
        recyclerUser!!.adapter = adapterPeople
    }


    override fun showUsers(results: ArrayList<Results?>?) {
        adapterPeople = AdapterPeopleList(results)
        recyclerUser!!.adapter = adapterPeople

    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
    }

    override fun noConnection() {
        noConnection!!.visibility = View.VISIBLE
    }
}