package org.remotefutures.core.impl.akkaactor.worker

object MasterWorkerProtocol {
  // Messages from Workers
  case class RegisterWorker(workerId: String)
  case class RequestForWork(workerId: String)
  case class WorkSuccess(workerId: String, workId: String, result: Any)
  case class WorkFailure(workerId: String, workId: String)

  // Messages to Workers
  case object WorkNeedsToBeDone
  case class WorkStatusAck(id: String)
}