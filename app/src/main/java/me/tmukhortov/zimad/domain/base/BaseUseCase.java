package me.tmukhortov.zimad.domain.base;

import androidx.core.util.Preconditions;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

// TODO finish it later
public abstract class BaseUseCase<T, Params> {

    private final CompositeDisposable disposables;

    BaseUseCase() {
        this.disposables = new CompositeDisposable();
    }

    abstract Observable<T> buildUseCaseObservable(Params params);

    public void execute(DisposableSingleObserver<T> observer, Params params) {
        Preconditions.checkNotNull(observer);
        final Observable<T> observable = this.buildUseCaseObservable(params);
    }

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }
}
