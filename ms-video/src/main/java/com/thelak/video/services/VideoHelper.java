package com.thelak.video.services;

import com.thelak.core.models.UserInfo;
import com.thelak.database.entity.DbVideo;
import com.thelak.database.entity.DbVideoRating;
import com.thelak.database.entity.DbVideoViews;
import com.thelak.route.category.models.CategoryModel;
import com.thelak.route.speaker.models.SpeakerModel;
import com.thelak.route.video.models.VideoModel;
import com.thelak.route.video.models.VideoSourceModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class VideoHelper {

    public static List<VideoSourceModel> createSources(DbVideo dbVideo, UserInfo userInfo) {
        if (userInfo != null && userInfo.isSubscribe()) {
            List<VideoSourceModel> sourceModels = new ArrayList<>();
            sourceModels.add(VideoSourceModel.builder()
                    .src(dbVideo.getContentUrl360())
                    .type("video/mp4")
                    .label("360p")
                    .res(360).build());
            sourceModels.add(VideoSourceModel.builder()
                    .src(dbVideo.getContentUrl480())
                    .type("video/mp4")
                    .label("480p")
                    .res(480).build());
            sourceModels.add(VideoSourceModel.builder()
                    .src(dbVideo.getContentUrl720())
                    .type("video/mp4")
                    .label("720p")
                    .res(720).build());
            sourceModels.add(VideoSourceModel.builder()
                    .src(dbVideo.getContentUrl1080())
                    .type("video/mp4")
                    .label("1080p")
                    .res(1080).build());
            return sourceModels;
        } else return null;
    }

    public static Integer avgRating(DbVideo dbVideo) {
        int sum = 0;
        List<DbVideoRating> ratings = dbVideo.getVideoToRating();
        if (ratings == null || ratings.size() == 0) return 0;
        for (DbVideoRating rating : ratings) {
            sum = sum + rating.getScore();
        }
        return sum / ratings.size();
    }

    public static Integer countView(DbVideo dbVideo) {
        try {
            List<DbVideoViews> views = dbVideo.getVideoToView();
            return views.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public static class SortByDate implements Comparator<VideoModel> {
        @Override
        public int compare(VideoModel a, VideoModel b) {
            return a.getCreatedDate().compareTo(b.getCreatedDate());
        }
    }

    public static VideoModel buildVideoModel(DbVideo dbVideo, List<CategoryModel> categoryModel, List<SpeakerModel> speakerModel, UserInfo userInfo, boolean fullData) {
        return VideoModel.builder()
                .id((Long) dbVideo.getObjectId().getIdSnapshot().get("id"))
                .title(dbVideo.getTitle())
                .description(fullData ? dbVideo.getDescription() : null)
                .year(fullData ? dbVideo.getYear() : null)
                .country(fullData ? dbVideo.getCountry() : null)
                .language(fullData ? dbVideo.getLanguage() : null)
                .category(categoryModel)
                .duration(dbVideo.getDuration())
                .speaker(speakerModel)
                .playground(fullData ? dbVideo.getPlayground() : null)
                .sources(fullData ? createSources(dbVideo, userInfo) : null)
                .rating(dbVideo.getRating())
                .viewsCount((long) dbVideo.getView())
                .partnerLogoUrl(fullData ? dbVideo.getPartnerLogoUrl() : null)
                .coverUrl(dbVideo.getCoverUrl())
                .posterUrl(dbVideo.getPosterUrl())
                .subscription(dbVideo.isIsSubscription())
                .createdDate(fullData ? dbVideo.getCreatedDate() : null)
                .build();
    }
}
