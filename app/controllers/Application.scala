package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._

object Application extends Controller {

  def index = itemManager

  def addMediaItemSrvc = Action(parse.urlFormEncoded) { implicit request =>
    val item = MediaItem.newItemForm.bindFromRequest.get
    MediaItem.addMedia(item)
    Redirect(routes.Application.itemManager)
  }

  def itemManager() = Action {
    val items = MediaItem.allMedia()
    Ok(views.html.item_manager(MediaItem.newItemForm, items))
  }

  /*def itemListUI = Action {
    val items = MediaItem.allMedia()
    Ok(views.html.item_list_ui())
  }*/

}