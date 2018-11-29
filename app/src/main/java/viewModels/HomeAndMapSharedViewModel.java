package viewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.view.View;


import com.example.user.catrunner.R;

import fragments.HomeFragment;

public class HomeAndMapSharedViewModel extends ViewModel {

    public FragmentTransaction fragmentTransaction;

    private MutableLiveData<Boolean> mMapOpened;
    private HomeFragment homeFragment;

    public void setHomeFragment(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    public void setMapOpened(View view) {
        boolean curMapOpened;
        if (view.getId() == R.id.btn_start) {
            curMapOpened = true;
            //    homeFragment.fragmentTransaction.replace(R.id.frgmCont, homeFragment);
        } else {
            curMapOpened = false;
        }
        if (curMapOpened != getMapOpened().getValue())
            mMapOpened.setValue(curMapOpened);
    }

    public MutableLiveData<Boolean> getMapOpened() {
        if (mMapOpened == null) {
            mMapOpened = new MutableLiveData<>();
            mMapOpened.setValue(false);
        }
        return mMapOpened;
    }
}