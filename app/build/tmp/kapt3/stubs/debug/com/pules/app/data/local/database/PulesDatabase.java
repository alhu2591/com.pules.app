package com.pules.app.data.local.database;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/pules/app/data/local/database/PulesDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "sourceDao", "Lcom/pules/app/data/local/database/dao/SourceDao;", "favoriteDao", "Lcom/pules/app/data/local/database/dao/FavoriteDao;", "readLaterDao", "Lcom/pules/app/data/local/database/dao/ReadLaterDao;", "noteDao", "Lcom/pules/app/data/local/database/dao/NoteDao;", "tagDao", "Lcom/pules/app/data/local/database/dao/TagDao;", "app_debug"})
@androidx.room.Database(entities = {com.pules.app.data.local.database.entity.SourceEntity.class, com.pules.app.data.local.database.entity.FavoriteEntity.class, com.pules.app.data.local.database.entity.ReadLaterEntity.class, com.pules.app.data.local.database.entity.NoteEntity.class, com.pules.app.data.local.database.entity.TagEntity.class, com.pules.app.data.local.database.entity.ArticleTagCrossRef.class}, version = 1, exportSchema = false)
public abstract class PulesDatabase extends androidx.room.RoomDatabase {
    
    public PulesDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.pules.app.data.local.database.dao.SourceDao sourceDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.pules.app.data.local.database.dao.FavoriteDao favoriteDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.pules.app.data.local.database.dao.ReadLaterDao readLaterDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.pules.app.data.local.database.dao.NoteDao noteDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.pules.app.data.local.database.dao.TagDao tagDao();
}