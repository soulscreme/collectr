package models

import anorm.SqlParser._
import anorm._
import play.api.db.DB
import anorm.~
import play.api.Play.current

/**
 * Created by soulscreme on 5/12/14.
 */
case class LibraryItem(libraryId: Long, mediaId: Long)

object LibraryItem {
  val libraryItem = {
    get[Long]("library_id") ~
      get[Long]("media_id") map {
      case libraryId~mediaId => LibraryItem(libraryId, mediaId)
    }
  }

  val mediaIdParser = {
    get[String]("media_id") map { case mediaId => mediaId }
  }

  def allMediaIdsByLibrary(libraryId: Int) = {
    DB.withConnection { implicit c =>
      SQL("select media_id from library_media where library_id = {libraryId}").on(
        'libraryId -> libraryId
      ).as(mediaIdParser *)
    }
  }

  def allLibraryItemsByLibrary(libraryId: Int) = {
    DB.withConnection { implicit c =>
      SQL("select * from library_media where library_id = {libraryId}").on(
        'libraryId -> libraryId
      ).as(libraryItem *)
    }
  }

  def allLibraryItemsByItem(mediaId: Int) = {
    DB.withConnection { implicit c =>
      SQL("select * from library_media where media_id = {mediaId}").on(
        'mediaId -> mediaId
      ).as(libraryItem *)
    }
  }

  def addMedia(libraryId: Int, mediaId: Int) {
    DB.withConnection { implicit c =>
        SQL("insert into library_media (library_id, media_id) " +
          "values ({libraryId}, {mediaId}").on(
            'libraryId -> libraryId,
            'mediaId -> mediaId
          ).executeUpdate()
    }
  }
}