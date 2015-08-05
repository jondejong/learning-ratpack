import ratpack.groovy.template.MarkupTemplateModule
import ratpack.jackson.guice.JacksonModule

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack
import static ratpack.jackson.Jackson.json

ratpack {
  bindings {
    module MarkupTemplateModule
    module JacksonModule    
  }

  handlers {
    get {
      render groovyMarkupTemplate("index.gtpl", title: "My Ratpack App")
    }

    get ('things') {
        def things = [
                [name: 'jon', type: 'human'],
                [name: 'bear', type: 'dog']
        ]
        render json(things)
    }

    files { dir "public" }
  }
}
