package com.mck.samples.webapp.mediator;

public interface IAmCommandHandler<TCommand extends IAmCommand<TResponse>,TResponse> {
    TResponse handle(TCommand command);
}
