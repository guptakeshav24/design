class CA{
  public void b1(){
    //logic
  }
}
//1. is a 
class CB extends CA{
  public void b1(){
    //extra logic
      super.b1();
     //extra logic
  }
}


//2. has a <-- proxy pattern
class CB {
  CA ref = new CA();
  
  public void b1(){
    //extra logic
      ref.b1();
     //extra logic
  }
}



//3. linked list of has a (chain of proxy) <-- docrator pattern
interface IX{
  void b1();
}
class CA implements IX{
  public void b1(){
    //logic
  }
}
class CB implements IX {
  IX ref;
  public void b1(){
    //extra logic
      ref.b1();
     //extra logic
  }
}
IX obj = new CB(new CB(new CB(new CA())));
obj.b1();



//4. collection of has a
class CA {
  List<IX> enrichers;
  public void b1(){
    for(IX enricher in enrichers)
      enricher.enrich(this);
    //logic
  }
}
interface IX{
  void enrich(CA obj);
}
class CB implements IX {
  public void enrich(CA obj){
    //extra logic
      obj.b1();
     //extra logic
  }
}
