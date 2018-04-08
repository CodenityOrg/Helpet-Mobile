package com.kincodi.helpet.helpetmobile.presentation.ui.fragments.Detail;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.domain.executor.impl.ThreadExecutor;
import com.kincodi.helpet.helpetmobile.domain.model.Photo;
import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.presentation.presenters.GetPostInfoPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.impl.Post.GetPostInfoPresenterImpl;
import com.kincodi.helpet.helpetmobile.presentation.ui.adapter.PetFragmentPageAdapter;
import com.kincodi.helpet.helpetmobile.storage.PostRepositoryImpl;
import com.kincodi.helpet.helpetmobile.threading.MainThreadImpl;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment implements GetPostInfoPresenter.View {

    private SliderLayout mDemoSlider;
    GetPostInfoPresenterImpl getPostInfoPresenter;
    PostRepositoryImpl postRepository;


    @BindView(R.id.txtName)
    TextView txtName;

    @BindView(R.id.txtRace)
    TextView txtRace;

    @BindView(R.id.txtDescription)
    TextView txtDescription;

    @BindView(R.id.txtKind)
    TextView txtKind;

    @BindView(R.id.txtCellphone)
    TextView txtCellphone;

    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        postRepository = new PostRepositoryImpl();

        getPostInfoPresenter = new GetPostInfoPresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), postRepository, this);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_info, container, false);

        mDemoSlider = view.findViewById(R.id.slider);

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);

        ButterKnife.bind(this, view);

        String postId = "5ac65811e7ba535f66ed7f6b";
        getPostInfoPresenter.getInfo(postId);


        return view;
    }

    @Override
    public void gotInfo(Post post) {
        txtKind.setText(post.getKind());
        txtName.setText(post.getName());
        txtRace.setText(post.getRace());
        txtCellphone.setText(post.getPhone());
        txtDescription.setText(post.getDescription());

        for (Photo photo: post.getPhotos()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView
                    .description(photo.getName())
                    .image("http://192.168.1.35:3000" + photo.getPath())
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            mDemoSlider.addSlider(textSliderView);
        }
    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }
}
