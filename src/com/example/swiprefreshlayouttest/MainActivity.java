package com.example.swiprefreshlayouttest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView mListView;
	private ArrayAdapter<String> adapter;
	
	private String[] items={"2","3","2","3","2","3","2","3","2","3","2","3","2","3"};
	private SwipeRefreshLayout swipeLayout;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListView=(ListView)findViewById(R.id.list_view);
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
		mListView.setAdapter(adapter);
		/*
		 * SwipeRefreshLayout 控件，实现下拉刷新效果
		 * 它的child必须是可滚动的view，例如ListView，ScrollView，WebView
		 */
		swipeLayout=(SwipeRefreshLayout)findViewById(R.id.swipe_container);
		
		
		/*
		 * 刷新时显示的四种颜色
		 */
		swipeLayout.setColorScheme(android.R.color.holo_blue_bright,android.R.color.holo_green_light,
				android.R.color.holo_orange_light,android.R.color.holo_red_light);
		swipeLayout.setOnRefreshListener(new OnRefreshListener(){

			@Override
			public void onRefresh() {
				new Handler().postDelayed(new Runnable(){

					@Override
					public void run() {
						swipeLayout.setRefreshing(false);
						
					}
					
				},5000);
				
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
