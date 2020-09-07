package com.thelak.database.entity.auto;

import java.time.LocalDateTime;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _DbArticle was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _DbArticle extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "id";

    public static final Property<String> AUTHOR = Property.create("author", String.class);
    public static final Property<String> CONTENT = Property.create("content", String.class);
    public static final Property<String> COVER_URL = Property.create("coverUrl", String.class);
    public static final Property<LocalDateTime> CREATED_DATE = Property.create("createdDate", LocalDateTime.class);
    public static final Property<LocalDateTime> DELETED_DATE = Property.create("deletedDate", LocalDateTime.class);
    public static final Property<String> DESCRIPTION = Property.create("description", String.class);
    public static final Property<LocalDateTime> MODIFIED_DATE = Property.create("modifiedDate", LocalDateTime.class);
    public static final Property<String> SOURCE_URL = Property.create("sourceUrl", String.class);
    public static final Property<String> TITLE = Property.create("title", String.class);

    public void setAuthor(String author) {
        writeProperty("author", author);
    }
    public String getAuthor() {
        return (String)readProperty("author");
    }

    public void setContent(String content) {
        writeProperty("content", content);
    }
    public String getContent() {
        return (String)readProperty("content");
    }

    public void setCoverUrl(String coverUrl) {
        writeProperty("coverUrl", coverUrl);
    }
    public String getCoverUrl() {
        return (String)readProperty("coverUrl");
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        writeProperty("createdDate", createdDate);
    }
    public LocalDateTime getCreatedDate() {
        return (LocalDateTime)readProperty("createdDate");
    }

    public void setDeletedDate(LocalDateTime deletedDate) {
        writeProperty("deletedDate", deletedDate);
    }
    public LocalDateTime getDeletedDate() {
        return (LocalDateTime)readProperty("deletedDate");
    }

    public void setDescription(String description) {
        writeProperty("description", description);
    }
    public String getDescription() {
        return (String)readProperty("description");
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        writeProperty("modifiedDate", modifiedDate);
    }
    public LocalDateTime getModifiedDate() {
        return (LocalDateTime)readProperty("modifiedDate");
    }

    public void setSourceUrl(String sourceUrl) {
        writeProperty("sourceUrl", sourceUrl);
    }
    public String getSourceUrl() {
        return (String)readProperty("sourceUrl");
    }

    public void setTitle(String title) {
        writeProperty("title", title);
    }
    public String getTitle() {
        return (String)readProperty("title");
    }

}
