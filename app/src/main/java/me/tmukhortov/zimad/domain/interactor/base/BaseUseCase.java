package me.tmukhortov.zimad.domain.interactor.base;

public interface BaseUseCase<T> {

    /**
     * Make business logic
     *
     * @return return type held by this instance
     */
    T executeWithResult();

    /**
     * Make business logic
     */
    void execute();
}
