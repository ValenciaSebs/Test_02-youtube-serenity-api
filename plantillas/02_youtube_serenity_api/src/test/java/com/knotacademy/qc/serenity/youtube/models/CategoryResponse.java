package com.knotacademy.qc.serenity.youtube.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryResponse {
    @JsonProperty("kind")
    private String kind;

    @JsonProperty("etag")
    private String etag;

    @JsonProperty("items")
    private List<CategoryItem> items;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CategoryItem {
        @JsonProperty("kind")
        private String kind;

        @JsonProperty("etag")
        private String etag;

        @JsonProperty("id")
        private String id;

        @JsonProperty("snippet")
        private Snippet snippet;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Snippet {
            @JsonProperty("channelId")
            private String channelId;

            @JsonProperty("title")
            private String title;

            @JsonProperty("assignable")
            private Boolean assignable;

            public String getChannelId() { return channelId; }
            public String getTitle() { return title; }
            public Boolean isAssignable() { return assignable; }
        }

        public String getId() { return id; }
        public Snippet getSnippet() { return snippet; }
    }

    public List<CategoryItem> getItems() { return items; }
}
