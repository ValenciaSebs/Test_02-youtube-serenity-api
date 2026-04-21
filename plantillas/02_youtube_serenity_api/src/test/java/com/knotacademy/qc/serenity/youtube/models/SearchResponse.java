package com.knotacademy.qc.serenity.youtube.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponse {
    @JsonProperty("kind")
    private String kind;

    @JsonProperty("etag")
    private String etag;

    @JsonProperty("nextPageToken")
    private String nextPageToken;

    @JsonProperty("pageInfo")
    private PageInfo pageInfo;

    @JsonProperty("items")
    private List<SearchItem> items;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SearchItem {
        @JsonProperty("kind")
        private String kind;

        @JsonProperty("etag")
        private String etag;

        @JsonProperty("id")
        private ItemId id;

        @JsonProperty("snippet")
        private Snippet snippet;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ItemId {
            @JsonProperty("kind")
            private String kind;

            @JsonProperty("videoId")
            private String videoId;

            @JsonProperty("playlistId")
            private String playlistId;

            @JsonProperty("channelId")
            private String channelId;

            public String getKind() { return kind; }
            public String getVideoId() { return videoId; }
            public String getPlaylistId() { return playlistId; }
            public String getChannelId() { return channelId; }
        }

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

            @JsonProperty("thumbnails")
            private Thumbnails thumbnails;

            @JsonProperty("channelTitle")
            private String channelTitle;

            @JsonProperty("liveBroadcastContent")
            private String liveBroadcastContent;

            public String getTitle() { return title; }
            public String getDescription() { return description; }
            public String getChannelId() { return channelId; }
            public String getChannelTitle() { return channelTitle; }
            public String getPublishedAt() { return publishedAt; }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Thumbnails {
            @JsonProperty("default")
            private Thumbnail defaultThumbnail;

            @JsonProperty("medium")
            private Thumbnail medium;

            @JsonProperty("high")
            private Thumbnail high;

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Thumbnail {
                @JsonProperty("url")
                private String url;

                @JsonProperty("width")
                private Integer width;

                @JsonProperty("height")
                private Integer height;

                public String getUrl() { return url; }
            }
        }

        public ItemId getId() { return id; }
        public Snippet getSnippet() { return snippet; }
        public String getKind() { return kind; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PageInfo {
        @JsonProperty("totalResults")
        private Long totalResults;

        @JsonProperty("resultsPerPage")
        private Integer resultsPerPage;

        public Long getTotalResults() { return totalResults; }
        public Integer getResultsPerPage() { return resultsPerPage; }
    }

    public String getKind() { return kind; }
    public String getNextPageToken() { return nextPageToken; }
    public PageInfo getPageInfo() { return pageInfo; }
    public List<SearchItem> getItems() { return items; }
}
