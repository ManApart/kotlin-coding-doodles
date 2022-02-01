class Model()
interface Builder {
    fun build(): Model
}

class MockBuilder : Builder {
    override fun build(): Model {
        return Model()
    }
    fun assertCalled(): Boolean {
        return true
    }
}

interface Transformer {
    fun transform(model: Model): Model
}

class MockTransformer : Transformer {
    override fun transform(model: Model): Model {
        return Model()
    }
    fun assertCalled(): Boolean {
        return true
    }
}

interface Polisher {
    fun polish(model: Model): Model
}

class MockPolisher : Polisher {
    override fun polish(model: Model): Model {
        return Model()
    }
    fun assertCalled(): Boolean {
        return true
    }
}


fun doServiceThing(builder: Builder, transformer: Transformer, polisher: Polisher): Model {
    val model = builder.build()
    val updated = transformer.transform(model)
    return polisher.polish(updated)
}