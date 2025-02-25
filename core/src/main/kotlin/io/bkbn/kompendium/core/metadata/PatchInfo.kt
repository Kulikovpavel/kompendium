package io.bkbn.kompendium.core.metadata

import io.bkbn.kompendium.oas.common.ExternalDocumentation
import io.bkbn.kompendium.oas.payload.Parameter

class PatchInfo private constructor(
  override val request: RequestInfo,
  override val errors: MutableList<ResponseInfo>,
  override val response: ResponseInfo,
  override val tags: Set<String>,
  override val summary: String,
  override val description: String,
  override val externalDocumentation: ExternalDocumentation?,
  override val operationId: String?,
  override val deprecated: Boolean,
  override val parameters: List<Parameter>
) : MethodInfoWithRequest {

  companion object {
    fun builder(init: Builder.() -> Unit): PatchInfo {
      val builder = Builder()
      builder.init()
      return builder.build()
    }
  }

  class Builder : MethodInfoWithRequest.Builder<PatchInfo>() {
    override fun build() = PatchInfo(
      request = request ?: error("request info must be present"),
      errors = errors,
      response = response ?: error("response info must be present"),
      tags = tags,
      summary = summary ?: error("Summary must be present"),
      description = description ?: error("Description must be present"),
      externalDocumentation = externalDocumentation,
      operationId = operationId,
      deprecated = deprecated,
      parameters = parameters
    )
  }
}
