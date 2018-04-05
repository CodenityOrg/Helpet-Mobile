package com.kincodi.helpet.helpetmobile.presentation.ui.fragments.Detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.domain.model.Photo;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {

    private SliderLayout mDemoSlider;
    private List<TextSliderView> textSliderViews;
    private List<Photo> photos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mDemoSlider = getActivity().findViewById(R.id.slider);

        for (Photo photo: photos) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView
                    .description(photo.getName())
                    .image(photo.getUrl())
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);

        return inflater.inflate(R.layout.fragment_info, container, false);
    }

}
