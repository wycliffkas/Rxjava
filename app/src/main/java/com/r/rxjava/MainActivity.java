package com.r.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
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
//
//        Observable<Task> taskObservable = Observable
//                .fromIterable(DataSource.createTasksList())
//                .subscribeOn(Schedulers.io())
//                //filters and only emits completed tasks
//                .filter(new Predicate<Task>() {
//                    @Override
//                    public boolean test(Task task) throws Exception {
//                        Log.d(TAG, "Thread: " + Thread.currentThread().getName());
//                        return task.isComplete();
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread());


        //creating a new observer that subscribes to the observable

//        taskObservable.subscribe(new Observer<Task>() {
//            //called as soon as observable is subscribed to
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "onSubscribe: called");
//                disposable.add(d);
//            }
//
//            //called as observer iterates through observables
//            @Override
//            public void onNext(Task task) {
//                Log.d(TAG, "Thread: " + Thread.currentThread().getName());
//                Log.d(TAG, "Description: " + task.getDescription());
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "Error: ", e);
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "On complete");
//            }
//        });





        //Creating an Observable from a single object


//        final Task task = new Task("walk the dog", false, 4);
//
//        //create observable
//        Observable<Task> singleTaskObservable = Observable
//                .create(new ObservableOnSubscribe<Task>() {
//                    @Override
//                    public void subscribe(ObservableEmitter<Task> emitter) throws Exception {
//                        if(!emitter.isDisposed()){
//                            emitter.onNext(task);
//                            emitter.onComplete();
//                        }
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//
//        //subscribe to the observable and get emitted data
//
//        singleTaskObservable.subscribe(new Observer<Task>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Task task) {
//                Log.d(TAG, "Description: " + task.getDescription());
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });


        //Creating an Observable from a list of objects


//        Observable<Task> taskListObservable = Observable
//                .create(new ObservableOnSubscribe<Task>() {
//                    @Override
//                    public void subscribe(ObservableEmitter<Task> emitter) throws Exception {
//
//                        for(Task task: DataSource.createTasksList()){
//                            if(!emitter.isDisposed()){
//                                emitter.onNext(task);
//                            }
//                        }
//
//                        if(!emitter.isDisposed()){
//                            emitter.onComplete();
//                        }
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//
//        taskListObservable.subscribe(new Observer<Task>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Task task) {
//                Log.d(TAG, "Description: " + task.getDescription());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

        // just operator

//        Observable.just("first", "second", "third", "fourth", "fifth",
//                "sixth", "seventh", "eigth", "ninth", "tenth")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.d(TAG, "onNext:"+ s);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });


        // range and repeat operator

//        Observable.range(0,20)
//                .repeat(2)
//                .observeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "onNext:"+ integer);
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });


        //observable that emits after certain time interval

//        Observable<Long> intervalObservable = Observable
//                .interval(1, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .takeWhile(new Predicate<Long>() {
//                    @Override
//                    public boolean test(Long aLong) throws Exception {
//                        return aLong <= 10;
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread());
//
//                intervalObservable.subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        Log.d(TAG, "onNext: interval: " + aLong);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });


        // Timer operator

//        Observable<Long> timerObservable = Observable
//                .timer(1, TimeUnit.MINUTES)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//
//        timerObservable.subscribe(new Observer<Long>() {
//
//            long time = 0;
//            @Override
//            public void onSubscribe(Disposable d) {
//                time = System.currentTimeMillis() / 1000;
//
//            }
//
//            @Override
//            public void onNext(Long aLong) {
//                Log.d(TAG, "time delayed: " + ((System.currentTimeMillis()/1000) - time));
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

        // Filter operator

//        Observable<Task> filterObservable = Observable
//                .fromIterable(DataSource.createTasksList())
//                .filter(new Predicate<Task>() {
//                    @Override
//                    public boolean test(Task task) throws Exception {
//                        if(task.getDescription().equals("Walk the dog")){
//                            return true;
//                        }
//                        return false;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//
//        filterObservable.subscribe(new Observer<Task>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Task task) {
//                Log.d(TAG, "onNext: This task matches the description: " + task.getDescription());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

        // filter by boolean value

//        Observable<Task> booleanObservable = Observable
//                .fromIterable(DataSource.createTasksList())
//                .filter(new Predicate<Task>() {
//                    @Override
//                    public boolean test(Task task) throws Exception {
//                        return task.isComplete();
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//
//        booleanObservable.subscribe(new Observer<Task>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Task task) {
//                Log.d(TAG, "onNext: This task matches the description: " + task.getDescription());
//            }
//
//
//        @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });


    //Take Operator

//        Observable<Task> takeObservable = Observable
//                .fromIterable(DataSource.createTasksList())
//                .take(3)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//        takeObservable.subscribe(new Observer<Task>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Task task) {
//                Log.d(TAG, "onNext: This task matches the description: " + task.getDescription());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

        //TakeWhile Operator

//        Observable<Task> takeWhileObservable = Observable
//                .fromIterable(DataSource.createTasksList())
//                .takeWhile(new Predicate<Task>() {
//                    @Override
//                    public boolean test(Task task) throws Exception {
//                        return task.isComplete();
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//        takeWhileObservable.subscribe(new Observer<Task>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Task task) {
//                Log.d(TAG, "onNext: This task matches the description: " + task.getDescription());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });


        //Map Operator

//        Observable<Integer> intObservable = Observable
//                .range(1, 10)
//                .map(new Function<Integer, Integer>() {
//                    @Override
//                    public Integer apply(Integer integer) throws Exception {
//                        return integer * 2;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//        intObservable.subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Log.d(TAG, "onNext: " + integer);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });


        //Buffer Operator

        Observable<Task> bufferObservable = Observable
                .fromIterable(DataSource.createTasksList())
                .subscribeOn(Schedulers.io());
        bufferObservable
                .buffer(2)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Task>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Task> tasks) {
                Log.d(TAG, "-------------------------------");
                for(Task task: tasks){
                    Log.d(TAG, "onNext: " +  task.getDescription());
                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

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
