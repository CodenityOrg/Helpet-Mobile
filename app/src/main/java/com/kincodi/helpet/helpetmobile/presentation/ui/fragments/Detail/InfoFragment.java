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
import com.kincodi.helpet.helpetmobile.domain.model.Photo;
import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.presentation.presenters.impl.Post.GetPostInfoPresenterImpl;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {

    private SliderLayout mDemoSlider;
    private Post post;

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

        try {
            post = getArguments().getParcelable("post");

            txtKind.setText(post.getKind());
            txtName.setText(post.getName());
            txtRace.setText(post.getRace());
            txtCellphone.setText(post.getPhone());
            txtDescription.setText(post.getDescription());

            for (Photo photo: post.getPhotos()) {
                TextSliderView textSliderView = new TextSliderView(getActivity());
                textSliderView
                        .description(photo.getName())
                        .image(photo.getPath())
                        .setScaleType(BaseSliderView.ScaleType.Fit);
                mDemoSlider.addSlider(textSliderView);
            }

        }catch (Exception e) {

        }

        return view;
    }

}
