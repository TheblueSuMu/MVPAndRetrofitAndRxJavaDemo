package com.lc.huluobo.mvpandretrofitandrxjavademo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lc.huluobo.mvpandretrofitandrxjavademo.R;
import com.lc.huluobo.mvpandretrofitandrxjavademo.service.entity.Book;
import com.lc.huluobo.mvpandretrofitandrxjavademo.service.presenter.BookPresenter;
import com.lc.huluobo.mvpandretrofitandrxjavademo.service.view.BookView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private BookPresenter bookPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        button = findViewById(R.id.btn);
        bookPresenter = new BookPresenter(this, "https://api.douban.com/v2/");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookPresenter.getSearchBooks("金瓶梅", null, 0, 1);
            }
        });

        bookPresenter.onCreate();
        bookPresenter.attachView(bookView);
    }

    private BookView bookView = new BookView() {
        @Override
        public void onSuccess(Book book) {
            textView.setText(book.toString());
        }

        @Override
        public void onError(String error) {
            Toast.makeText(MainActivity.this, "error:" + error, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        bookPresenter.onStop();
    }
}
