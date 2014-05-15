package models

import anorm.SqlParser._
import anorm._
import play.api.db.DB
import anorm.~
import java.util.NoSuchElementException
import play.api.Play.current

/**
 * Created by soulscreme on 5/12/14.
 */
case class UserLibrary(id: Long, name: String, userId: Long)

object UserLibrary {
  val library = {
    get[Long]("id") ~
      get[String]("name") ~
      get[Long]("user_id") map {
      case id~name~userId => UserLibrary(id, name, userId)
    }
  }

  def allLibraries() = {
    DB.withConnection { implicit c =>
      SQL("select * from user_libraries").as(library *)
    }
  }

  def getLibrary(id: Long) = {
    DB.withConnection { implicit c =>
      SQL("select * from user_libraries where id = {id}").on(
        'id -> id
      ).as(library *)
    }
  }

  def getLibraryId(name: String, userId: Long) = {
    try{
      Some(DB.withConnection { implicit c =>
        SQL("select id from user_libraries where upper(name) = upper({name}) " +
          "and user_id = {userId}").on(
            'name -> name,
            'userId -> userId
          ).apply().head[Long]("id")
      })
    } catch {
      case nse: NoSuchElementException => None
    }
  }

  def addLibrary(name: String, userId: Long) {
    //Add the item only if another item with the same description, price, and merchant does not exist
    getLibraryId(name, userId) match {
      case Some(x) => {}
      case None => DB.withConnection { implicit c =>
        SQL("insert into user_libraries (name, user_id) values ({name}, {userId})").on(
          'name -> name,
          'userId -> userId
        ).executeUpdate()
      }
    }
  }
}
