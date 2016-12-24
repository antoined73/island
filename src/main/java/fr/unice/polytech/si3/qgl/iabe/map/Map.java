package fr.unice.polytech.si3.qgl.iabe.map;

import fr.unice.polytech.si3.qgl.iabe.Bot;
import fr.unice.polytech.si3.qgl.iabe.Direction;
import fr.unice.polytech.si3.qgl.iabe.Drone;
import fr.unice.polytech.si3.qgl.iabe.Resources.ResultParser;
import fr.unice.polytech.si3.qgl.iabe.decisions.Decision;
import fr.unice.polytech.si3.qgl.iabe.decisions.Echo;
import fr.unice.polytech.si3.qgl.iabe.observer.Observer;
import fr.unice.polytech.si3.qgl.iabe.result.EchoResult;
import fr.unice.polytech.si3.qgl.iabe.result.Result;
import fr.unice.polytech.si3.qgl.iabe.result.ResultFactory;
import fr.unice.polytech.si3.qgl.iabe.strategy.Compass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Antoine on 12/3/2016.
 */
public class Map extends Observer {

    private Drone drone;
    private List<AirTile> map;

    public Map(Bot bot, Drone drone) {
        super(bot);
        this.subject.addObserver(this);
        this.drone = drone;
        this.map = new ArrayList<>();

        Direction firstSide = new Compass().getOppositeOf(drone.getCurrentDirection());
        map.add(new AirTile(0,0));
    }

    public void addColumnsEst(int xDrone, int yDrone, int numberOfColumnsToAdd) {
        for (int i = 0; i < numberOfColumnsToAdd; i++) {
            addOneColumn(xDrone+i+1);
        }
    }

    private void addColumnsWest(int xDrone, int yDrone, int numberOfColumnsToAdd) {
        for (int i = 0; i < numberOfColumnsToAdd; i++) {
            addOneColumn(xDrone-i-1);
        }
    }

    public void addOneColumn(int xCoordinate) {
        for (int i = getCurrentYMin(); i <= getCurrentYMax(); i++) {
            map.add(new AirTile(xCoordinate,i));
        }
    }

    public void addOneLine(int yCoordinate) {
        for (int i = getCurrentXMin(); i <= getCurrentXMax(); i++) {
            map.add(new AirTile(i,yCoordinate));
        }
    }


    public Drone getDrone() {
        return drone;
    }
/*
    private void actuMap(Drone drone, Result result, Decision previousDecision) {
        switch (previousDecision.getName()) {
            case "echo":
                EchoResult echoresult = (EchoResult) result;
                if (!echoresult.foundedGround()) {
                    Echo echo = (Echo) previousDecision;
                    Direction previousEchoHeading = echo.getDirection();
                    switch (previousEchoHeading) {
                        case E:
                            for (int i = drone.getX(); i <= sizeWidth; i++)
                                map[i][drone.getY()].setDiscovered(true);
                            break;
                        case N:
                            for (int i = drone.getY(); i >= 0; i--)
                                map[drone.getX()][i].setDiscovered(true);
                            break;
                        case W:
                            for (int i = drone.getX(); i >= 0; i--)
                                map[i][drone.getY()].setDiscovered(true);
                            break;
                        case S:
                            for (int i = drone.getY(); i <= sizeHeight; i++)
                                map[drone.getX()][i].setDiscovered(true);
                            break;
                    }
                }
                break;
            case "scan":
                // NOT IMPLEMENTED YET
                break;
            default:
                break;
        }
    }*/

    public boolean isDiscovered(Direction heading, int posDroneX, int posDroneY) {
        Optional<AirTile> airTile;
        switch (heading) {
            case E:
                airTile = getAirTile(posDroneX+1,posDroneY);
                break;
            case S:
                airTile = getAirTile(posDroneX,posDroneY+1);
                break;
            case W:
                airTile = getAirTile(posDroneX-1,posDroneY);
                break;
            case N:
                airTile = getAirTile(posDroneX,posDroneY-1);
                break;
            default: airTile = Optional.empty(); break;
        }
        if(airTile.isPresent()){
            return  airTile.get().isDiscovered();
        }else{
            return false;
        }
    }

    public boolean foundGround(Direction heading, int posDroneX, int posDroneY) {
        switch (heading) {
            case E:
                for (AirTile airTile: map) {
                    if(airTile.getY()==posDroneY && airTile.getX() > posDroneX)
                        if (airTile.isGround())
                            return true;
                }
                break;
            case S:
                for (AirTile airTile: map) {
                    if(airTile.getX()==posDroneX && airTile.getY() > posDroneY)
                        if (airTile.isGround())
                            return true;
                }
                break;
            case W:
                for (AirTile airTile: map) {
                    if(airTile.getY()==posDroneY && airTile.getX() < posDroneX)
                        if (airTile.isGround())
                            return true;
                }
                break;
            case N:
                for (AirTile airTile: map) {
                    if(airTile.getX()==posDroneX && airTile.getY() < posDroneY)
                        if (airTile.isGround())
                            return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    @Override
    public void update() {
        //Result & previous decision
        ResultParser resultParser = subject.getResultParser();
        Decision previousDecision = subject.getPreviousDecision();
        Result result = new ResultFactory(resultParser, previousDecision).getResult();

        switch (previousDecision.getName()) {
            case "echo":
                EchoResult echoResult = (EchoResult) result;
                actuWithEchoResult(echoResult, (Echo) previousDecision);
                //TODO
        }
    }


    public void update(Decision previousDecision, Result result) {
        //Result & previous decision
        switch (previousDecision.getName()) {
            case "echo":
                EchoResult echoResult = (EchoResult) result;
                actuWithEchoResult(echoResult, (Echo) previousDecision);
                //TODO
        }
    }
    private void actuWithEchoResult(EchoResult result, Echo previousDecision) {
        int range= result.getRange();
        if(result.foundedGround()) range++;

        switch (previousDecision.getDirection()) {
            case E: addColumnsEst(drone.getX(),drone.getY(),range); break;
            case W: addColumnsWest(drone.getX(),drone.getY(),range); break;
            case N: addLinesNorth(drone.getX(),drone.getY(),range); break;
            case S: addLinesSouth(drone.getX(),drone.getY(),range); break;
        }
    }

    private void addLinesSouth(int x, int y, int range) {
        for (int i = 0; i < range; i++) {
            addOneLine(y+i+1);
        }
    }

    private void addLinesNorth(int x, int y, int range) {
        for (int i = 0; i < range; i++) {
            addOneLine(y-i-1);
        }
    }

    public int getCurrentXMin() {
        int min = map.get(0).getX();
        for(AirTile airTile: map) {
            int current = airTile.getX();
            if(current < min) min = current;
        }
        return min;
    }

    public int getCurrentXMax() {
        int max = map.get(0).getX();
        for(AirTile airTile: map) {
            int current = airTile.getX();
            if(current > max) max = current;
        }
        return max;
    }

    public int getCurrentYMin() {
        int min = map.get(0).getY();
        for(AirTile airTile: map) {
            int current = airTile.getY();
            if(current < min) min = current;
        }
        return min;
    }

    public int getCurrentYMax() {
        int max = map.get(0).getY();
        for(AirTile airTile: map) {
            int current = airTile.getY();
            if(current > max) max = current;
        }
        return max;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int xMax = getCurrentXMax();
        int xMin = getCurrentXMin();
        int yMax = getCurrentYMax();
        int yMin = getCurrentYMin();
        for(int y = yMin; y< yMax+1;y++){
            for(int x = xMin; x< xMax+1;x++){
                Optional<AirTile> airTile = getAirTile(x,y);
                if(airTile.isPresent()){
                    String xString = (airTile.get().getX()<0?""+airTile.get().getX():" "+airTile.get().getX());
                    String yString = (airTile.get().getY()<0?""+airTile.get().getY():" "+airTile.get().getY());
                    sb.append("|"+xString+","+yString+"|");
                }else{
                    sb.append("|.....|");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private Optional<AirTile> getAirTile(int x, int y) {
        for(AirTile air: map){
            if(air.getY()==y&&air.getX()==x){
                return Optional.of(air);
            }
        }
        return Optional.empty();
    }
}
