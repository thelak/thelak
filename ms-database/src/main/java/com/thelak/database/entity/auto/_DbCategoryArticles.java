package com.thelak.database.entity.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.thelak.database.entity.DbCategory;

/**
 * Class _DbCategoryArticles was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _DbCategoryArticles extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "id";

    public static final Property<Long> ID_ARTICLE = Property.create("idArticle", Long.class);
    public static final Property<DbCategory> ARTICLE_TO_CATEGORY = Property.create("articleToCategory", DbCategory.class);

    public void setIdArticle(long idArticle) {
        writeProperty("idArticle", idArticle);
    }
    public long getIdArticle() {
        Object value = readProperty("idArticle");
        return (value != null) ? (Long) value : 0;
    }

    public void setArticleToCategory(DbCategory articleToCategory) {
        setToOneTarget("articleToCategory", articleToCategory, true);
    }

    public DbCategory getArticleToCategory() {
        return (DbCategory)readProperty("articleToCategory");
    }


}
