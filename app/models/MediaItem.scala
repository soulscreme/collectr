package models

import anorm.SqlParser._
import anorm._
import play.api.db.DB
import java.util.NoSuchElementException
import play.api.Play.current
import play.api.data._
import play.api.data.Forms._

/**
 * Created by soulscreme on 5/12/14.
 */
case class MediaItem(id: Long, year: Int, title: String, description: String, image: String)

object MediaItem {
  val newItemForm = Form(
    mapping (
      "id" -> ignored(0L),
      "year" -> number,
      "title" -> text,
      "description" -> text,
      "image" -> text
    )(MediaItem.apply)(MediaItem.unapply)
  )

  val media = {
    get[Long]("id") ~
      get[Int]("year") ~
      get[String]("title") ~
      get[String]("description") ~
      get[String]("image") map {
      case id~year~title~description~image => MediaItem(id, year, title, description, image)
    }
  }

  def allMedia() = {
    DB.withConnection { implicit c =>
      SQL("select * from media_item").as(media *)
    }
  }

  def getMedia(id: Long) = {
    DB.withConnection { implicit c =>
      SQL("select * from media_item where id = {id}").on(
        'id -> id
      ).as(media *)
    }
  }

  def getMediaId(title: String, year: Int) = {
    try{
      Some(DB.withConnection { implicit c =>
        SQL("select id from media_item where upper(title) = upper({tiel}) " +
            "and year = {year}").on(
            'title -> title,
            'year -> year
          ).apply().head[Long]("id")
      })
    } catch {
      case nse: NoSuchElementException => None
    }
  }

  def addMedia(item: MediaItem) {
    getMediaId(item.title, item.year) match {
      case Some(x) => {}
      case None => DB.withConnection { implicit c =>
        SQL("insert into media_item (year, title, description, image) " +
          "values ({year}, {title}, {description}, {image})").on(
          'year -> item.year,
          'title -> item.title,
          'description -> item.description,
          'image -> item.image
        ).executeUpdate()
      }
    }
  }
}
