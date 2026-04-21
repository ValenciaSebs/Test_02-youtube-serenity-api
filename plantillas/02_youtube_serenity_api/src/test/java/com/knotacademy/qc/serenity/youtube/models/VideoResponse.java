package com.knotacademy.qc.serenity.youtube.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoResponse {
    @JsonProperty("kind")
    private String kind;

    @JsonProperty("etag")
    private String etag;

    @JsonProperty("pageInfo")
    private PageInfo pageInfo;

    @JsonProperty("items")
    private List<VideoItem> items;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VideoItem {
        @JsonProperty("kind")
        private String kind;

        @JsonProperty("etag")
        private String etag;

        @JsonProperty("id")
        private String id;

        @JsonProperty("snippet")
        private Snippet snippet;

        @JsonProperty("statistics")
        private Statistics statistics;

        @JsonProperty("contentDetails")
        private ContentDetails contentDetails;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Snippet {
            @JsonProperty("publishedAt")
            private String publishedAt;

            @JsonProperty("channelId")
            private String channelId;

            @JsonProperty("title")
            private String title;

            @JsonProperty("description")
            private String description;

            @JsonProperty("channelTitle")
            private String channelTitle;

            public String getTitle() { return title; }
            public String getDescription() { return description; }
            public String getChannelId() { return channelId; }
            public String getChannelTitle() { return channelTitle; }
            public String getPublishedAt() { return publishedAt; }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Statistics {
            @JsonProperty("viewCount")
            private String viewCount;

            @JsonProperty("likeCount")
            private String likeCount;

            @JsonProperty("commentCount")
            private String commentCount;

            public String getViewCount() { return viewCount; }
            public String getLikeCount() { return likeCount; }
            public String getCommentCount() { return commentCount; }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ContentDetails {
            @JsonProperty("duration")
            private String duration;

            @JsonProperty("dimension")
            private String dimension;

            @JsonProperty("definition")
            private String definition;

            public String getDuration() { return duration; }
            public String getDimension() { return dimension; }
            public String getDefinition() { return definition; }
        }

        public String getId() { return id; }
        public Snippet getSnippet() { return snippet; }
        public Statistics getStatistics() { return statistics; }
        public ContentDetails getContentDetails() { return contentDetails; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PageInfo {
        @JsonProperty("totalResults")
        private Integer totalResults;

        @JsonProperty("resultsPerPage")
        private Integer resultsPerPage;

        public Integer getTotalResults() { return totalResults; }
        public Integer getResultsPerPage() { return resultsPerPage; }
    }

    public List<VideoItem> getItems() { return items; }
    public PageInfo getPageInfo() { return pageInfo; }
}
