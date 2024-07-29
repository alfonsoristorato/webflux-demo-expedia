package webfluxdemo.reactive.exception

class BadRequestException(val error: Error) : RuntimeException(error.details)
