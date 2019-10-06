package me.tmukhortov.zimad.presentation.animal.list.livedata;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import me.tmukhortov.zimad.data.entity.Animal;

public class AnimalLiveData extends LiveData<List<Animal>> {

    private MutableLiveData<List<Animal>> animalList = new MutableLiveData<>();

    public LiveData<List<Animal>> getAnimalList() {
        String s = "";
        return animalList;
    }

    public void setAnimalList(MutableLiveData<List<Animal>> animalList) {
        this.animalList = animalList;
    }

    @Override
    public void observe(@NonNull LifecycleOwner owner,
                        @NonNull Observer<? super List<Animal>> observer) {
        super.observe(owner, observer);
    }
}
