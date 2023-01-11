Angular
=============================================================================================

    is a Javascript framework for constructing SPA(s).

    SPA - Single Page Application
    
     Web-Server                                             Browser
        spa-bundle       <-----------------REQ----------                                   
            index.html  --------RESP (spa-bundle)----------> load the index.html page along with the 
            + .css                                           assosiated .js and .css
            + .js
            + media
                                                            clicking a link/submiting a form or
                                                            any other event is handled by the javascript
                                                            loaded on the client machine.

                                                            in response to the evetn javascript can
                                                            generate html dynamically and update the relevent
                                                            section of the page rather than reloading the entire page.

    db  <---> rest-api  <-------------------REQ------------ Data Operation requests (CRUD) by .js on client
                        -----------------RESP (JSON) ------> json is received by .js and genertes releven html
                                                                and tailors it onto the index page.

    Angular Evolution
    ------------------

        angularjs                   angular library writen in native javascript.
        Angular 2                   angualr libraries are writen in Typescript.
        Angular 4
                5
                6
                7
                .......15


    Typescript?
    ---------------------
        typescript = javascript(ES)  + data-types and variable type safty.

        typescript is not understood by any browser.

        typescript is transpelled (compiled) into javascript before we deploy our app.

        Employee.js                             Employee.ts
         class Employee {                           class Employee{
                                                        empId:number;
                                                        name:string;
                                                        sal:number;

            constrcutor(empId,name,sal){                constrcutor(empId:number,name:string,sal:number){
                this.empId=empId;                           this.empId=empId; 
                this.name=name;                             this.name=name;
                this.sal=sal;                               this.sal=sal;
            }                                           }

            ta(){                                       ta():number{
                return this.sal*0.05;                       return this.sal*0.05;
            }                                           }
         }                                           }

    Angular Archetecture
    ----------------------

        an angular application is made up of a varity of typescript classes. Each angular resource
        is a typescript class marked with a decorator. Each decorator is supplied with a json object
        called meta-data comprising of configuration details.

        Angular Resources

            Module

                    angular module is a unit of code that has to be loaded on to the browser memory.
                    angular modules are different from Javascript modules and they both live side by side.
                    each angular project is contained in a top-level module called 'root-module'.
                    other angular modules are called 'feature-modules'.

                    @NgModule({
                        declarations:[],
                        imports:[],
                        exports:[],
                        providers:[],
                        bootstrap:[]
                    })
                    class SalesModule {}

                    declarations   hold a list of components,pipes and directives that belong to this module.
                    imports        hold a list of feature-modules that are to be imported in the current module.
                    exports        hold a list of components,pipes and directives that belong to this module and are to be exported.
                                   root-module will not have 'exports' section.
                    providers      hold a list of services that belon to the currewnt module 
                    bootstrap      holds a list of top-level components 
                                   root-modules are expected to have 'bootstrap' section.

            Directive

                Angular features html extendability. it means that we can create our own
                elements and attributes in angular.

                Component Directive / Component

                    A component is an extended html element/tag.

                    Component =     STATE,BEHAVIOUR       +       VIEW        +       STYLE
                                        component.ts            component.html          component.css

                    dashboard.component.ts
                            
                            @Component({
                                selector:'dashboard',
                                templateUrl:'dashboard.component.html',
                                stylesUrl:['dashboard.component.css']
                            })
                            class DashboardComponent {
                                webTitle:string;

                                constructor(){
                                    this.webTitle="Vamsy's Exports and Imports";
                                }
                            }

                    dashboard.component.html

                            <h3>{{webTitle}}</h3>
                    
                    dashboard.component.css
                            h3 {
                                border-bottom:1px solid black;
                            }
                    
                    <dashboard></dashbord>

                Attribute Directive

                    An attribute directive is an extended html attribute.
                    
                    @Directive({
                        selector:'fast-moving'
                    })
                    class FastMovingStock {}
                
                    <li fast-moving></li>

                Structural Directive

            Service

                    @Injectable({
                        providedIn:'root'
                    })
                    class SalesService {}

            Pipe
            
                    @Pipe({
                        name:'in-words'
                    })
                    class InWordsPipe {}


    Angular CLI
    ----------------------
        is an angular project structure and management tool.

        it is a javascript tool that runs on NodeJS.

        npm install -g @angular/cli

        ng version

        ng new proj-name            create a new angular project
        ng serve                    bundle the app and host it on a angular live developemnt server @ port 4200
        ng serve -o                 bundle the app and host it on a angular live developemnt server @ port 4200, opens app on browser
        ng serve --port 9999        bundle the app and host it on a angular live developemnt server @ port 9999
        ng serve --port 9999 -o     bundle the app and host it on a angular live developemnt server @ port 9999, opens app on browser
        ng build                    bundle the app and saves the target files in 'dist' folder
        ng test                     bundle the app and execute all test cases (if any)

        ng generate component ComponentName 
        ng g component ComponentName 
        ng g component ComponentName --skip-tests
        ng g c ComponentName --skip-tests
        ng g module ModuleName
        ng g class ClassName --skip-tests
        ng g directive DirectiveName --skip-tests
        ng g pipe PipeName --skip-tests
        ng g service ServiceName --skip-tests
        ng g interface InterfaceName 