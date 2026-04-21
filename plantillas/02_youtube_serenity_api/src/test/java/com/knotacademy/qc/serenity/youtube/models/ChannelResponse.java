package com.knotacademy.qc.serenity.youtube.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelResponse {
    @JsonProperty("kind")
    private String kind;

    @JsonProperty("etag")
    private String etag;

    @JsonProperty("pageInfo")
    private PageInfo pageInfo;

    @JsonProperty("items")
    private List<ChannelItem> items;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ChannelItem {
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

        @JsonProperty("brandingSettings")
        private BrandingSettings brandingSettings;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Snippet {
            @JsonProperty("title")
            private String title;

            @JsonProperty("description")
            private String description;

            @JsonProperty("customUrl")
            private String customUrl;

            @JsonProperty("publishedAt")
            private String publishedAt;

            @JsonProperty("thumbnails")
            private Thumbnails thumbnails;

            public String getTitle() { return title; }
            public String getDescription() { return description; }
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

                public String getUrl() { return url; }
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Statistics {
            @JsonProperty("viewCount")
            private String viewCount;

            @JsonProperty("subscriberCount")
            private String subscriberCount;

            @JsonProperty("videoCount")
            private String videoCount;

            public String getViewCount() { return viewCount; }
            public String getSubscriberCount() { return subscriberCount; }
            public String getVideoCount() { return videoCount; }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class BrandingSettings {
            @JsonProperty("channel")
            private ChannelBranding channel;

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ChannelBranding {
                @JsonProperty("title")
                private String title;

                @JsonProperty("description")
                private String description;

                public String getTitle() { return title; }
                public String getDescription() { return description; }
            }
        }

        public String getId() { return id; }
        public Snippet getSnippet() { return snippet; }
        public Statistics getStatistics() { return statistics; }
        public BrandingSettings getBrandingSettings() { return brandingSettings; }
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

    public List<ChannelItem> getItems() { return items; }
    public PageInfo getPageInfo() { return pageInfo; }
}
