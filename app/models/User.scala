package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import java.util.NoSuchElementException

case class User(id: Long, username: String, fname: String, lname: String, email: String, passwordHash: String)

object User {
  val user = {
    get[Long]("id") ~
      get[String]("username") ~
      get[String]("fname") ~
      get[String]("lname") ~
      get[String]("email") ~
      get[String]("passwordHash") map {
      case id~username~fname~lname~email~passwordHash => User(id, username, fname, lname, email, passwordHash)
    }
  }

  def allUsers() = {
    DB.withConnection { implicit c =>
      SQL("select * from users").as(user *)
    }
  }

  def getUser(id: Long) = {
    DB.withConnection { implicit c =>
      SQL("select * from users where id = {id}").on(
        'id -> id
      ).as(user *)
    }
  }

  def getUserId(username: String, fname: String, lname: String, email: String) = {
    try{
      Some(DB.withConnection { implicit c =>
        SQL("select id from users where upper(username) = upper({username}) " +
          "and upper(fname) = upper({fname}) " +
          "and upper(lname) = upper({lname}) " +
          "and upper(email) = upper({email})").on(
            'username -> username,
            'fname -> fname,
            'lname -> lname,
            'email -> email
          ).apply().head[Long]("id")
      })
    } catch {
      case nse: NoSuchElementException => None
    }
  }

  def addUser(username: String, fname: String, lname: String, email: String, passwordHash: String) {
    //Add the item only if another item with the same description, price, and merchant does not exist
    getUserId(username, fname, lname, email) match {
      case Some(x) => {}
      case None => DB.withConnection { implicit c =>
        SQL("insert into users (username, fname, lname, email, pass) values " +
          "({username}, {fname}, {lname}, {email}, {passwordHash})").on(
          'username -> username,
          'fname -> fname,
          'lname -> lname,
          'email -> email,
          'passwordHash -> passwordHash
        ).executeUpdate()
      }
    }
  }
}