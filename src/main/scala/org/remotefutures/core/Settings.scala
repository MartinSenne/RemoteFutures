/*
 * Copyright (c) 2014 Martin Senne, Marvin Hansen.
 */
package org.remotefutures.core

import scala.concurrent.duration.Duration
import com.typesafe.config.Config
import akka.util.Helpers.Requiring
import org.remotefutures.util.Helpers.ConfigOps


class Settings(val config: Config) {
  private val cc = config.getConfig("general")

  val FutureTimeout: Duration = {
    val key = "future-timeout-in-ms"
    cc.getString(key).toLowerCase match {
      case "off" ⇒ Duration.Undefined
      case _ ⇒ cc.getMillisDuration(key) requiring (_ > Duration.Zero, key + " > 0 ms, or off")
    }
  }

  val RemoteExecutionContextClassname : String = {
    cc.getString("remote-execution-context-classname")
  }
}

object Settings {
  def apply(c:Config) : Settings = {
    new Settings(c)
  }
}