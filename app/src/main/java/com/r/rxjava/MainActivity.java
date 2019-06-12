package com.r.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView text;

    private CompositeDisposable disposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating an observable object
        //takes a list of objects and turns em in an observable
        //thread to do the work on
        //thread to display results

        Observable<Task> taskObservable = Observable
                .fromIterable(DataSource.createTasksList())
                .subscribeOn(Schedulers.io())
                .filter(new Predicate<Task>() {
                    @Override
                    public boolean test(Task task) throws Exception {
                        Log.d(TAG, "Thread: " + Thread.currentThread().getName());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return task.isComplete();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());


        //creating a new observer that subscribes to the observable

        taskObservable.subscribe(new Observer<Task>() {
            //called as soon as observable is subscribed to
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: called");

                disposable.add(d);

            }

            //called as observer iterates thru observables
            @Override
            public void onNext(Task task) {
                Log.d(TAG, "Thread: " + Thread.currentThread().getName());
                Log.d(TAG, "Description: " + task.getDescription());
                

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error: ", e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "On complete");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //clearing observers
        disposable.clear();
    }
}
