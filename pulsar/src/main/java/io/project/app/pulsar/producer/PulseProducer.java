/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.pulsar.producer;

import io.github.majusko.pulsar.producer.PulsarTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author armena
 */
@Service
@Slf4j
public class PulseProducer {

    @Autowired
    private PulsarTemplate<String> producer;

    @Autowired
    private PulsarTemplate<String> producerExample;

    @Autowired
    private PulsarTemplate<String> producerEventFactory;

    public String sendToPulseEventChannel() {
        String event = "";
        Random rand = new Random();
        List<String> givenList = Arrays.asList("RED", "BLACK", "WHITE", "YELLOW", "GREEN", "BOOM");
        for (int i = 0; i < givenList.size(); i++) {
            int randomIndex = rand.nextInt(givenList.size());
            event = givenList.get(randomIndex);

        }
        try {
            log.info("Sending event " + event);
            if (event == null) {
                return "Not Send";
            }
            MessageId send = producerEventFactory.send("redline", event);
            return send.toString();
        } catch (PulsarClientException ex) {
            log.error("error during sending " + ex.getLocalizedMessage());
        }
        return "No Id";
    }

    public String ping() {
        try {

            MessageId send = producerExample.send("example-string-topic", "ms" + "-" + System.currentTimeMillis());
            return send.toString();
        } catch (PulsarClientException ex) {
            log.error("error during sending " + ex.getLocalizedMessage());
        }
        return "No Id";
    }

    public String sendToPulse(String msg) {
        try {
            log.info("Sending message " + msg);
            MessageId send = producer.send("pulse", msg + "-" + System.currentTimeMillis());
            return send.toString();
        } catch (PulsarClientException ex) {
            log.error("error during sending " + ex.getLocalizedMessage());
        }
        return "No Id";
    }

    public String sendToPulseJson() {
        try {
            log.info("Sending json ");
            MessageId send = producer.send("pulse", json);
            return send.toString();
        } catch (PulsarClientException ex) {
            log.error("error during sending " + ex.getLocalizedMessage());
        }
        return "No Id";
    }

    String json = "\"tripplans\": [\n"
            + "    {\n"
            + "      \"id\": 118,\n"
            + "      \"initialHos\": {\n"
            + "        \"remainingDuty\": 840.0,\n"
            + "        \"remainingDrive\": 660.0,\n"
            + "        \"remainingWeekly\": 4200.0,\n"
            + "        \"remainingBCP\": 480.0,\n"
            + "        \"cumulativeRest\": 4080.0\n"
            + "      },\n"
            + "      \"kpis\": {\n"
            + "        \"objectiveValue\": -8671.851485811112,\n"
            + "        \"violations\": 2,\n"
            + "        \"milage\": 787.38,\n"
            + "        \"driveMinutes\": 858.95,\n"
            + "        \"dutyMinutes\": 30.0,\n"
            + "        \"hos\": {\n"
            + "          \"remainingDuty\": 326.05,\n"
            + "          \"remainingDrive\": 281.05,\n"
            + "          \"remainingWeekly\": 3311.05,\n"
            + "          \"remainingBCP\": 480.0,\n"
            + "          \"cumulativeRest\": 120.0\n"
            + "        },\n"
            + "        \"buffer\": {\n"
            + "          \"initialBuffer\": 0.0\n"
            + "        }\n"
            + "      },\n"
            + "      \"details\": {\n"
            + "        \"start\": \"2021-08-24T13:44:04.563245234Z\",\n"
            + "        \"end\": \"2021-08-25T18:33:01.563245234Z\"\n"
            + "      },\n"
            + "      \"tripHos\": [\n"
            + "        {\n"
            + "          \"start\": \"2021-08-24T13:44:04.563245234Z\",\n"
            + "          \"end\": \"2021-08-24T13:59:04.563245234Z\",\n"
            + "          \"eventType\": \"ON_DUTY\",\n"
            + "          \"source\": \"PREDICTION\"\n"
            + "        },\n"
            + "        {\n"
            + "          \"start\": \"2021-08-24T13:59:04.563245234Z\",\n"
            + "          \"end\": \"2021-08-24T15:59:04.563245234Z\",\n"
            + "          \"eventType\": \"OFF_DUTY\",\n"
            + "          \"source\": \"PREDICTION\"\n"
            + "        },\n"
            + "        {\n"
            + "          \"start\": \"2021-08-24T15:59:04.563245234Z\",\n"
            + "          \"end\": \"2021-08-24T23:59:04.563245234Z\",\n"
            + "          \"eventType\": \"DRIVING\",\n"
            + "          \"source\": \"PREDICTION\"\n"
            + "        },\n"
            + "        {\n"
            + "          \"start\": \"2021-08-24T23:59:04.563245234Z\",\n"
            + "          \"end\": \"2021-08-25T09:59:04.563245234Z\",\n"
            + "          \"eventType\": \"OFF_DUTY\",\n"
            + "          \"source\": \"PREDICTION\"\n"
            + "        },\n"
            + "        {\n"
            + "          \"start\": \"2021-08-25T09:59:04.563245234Z\",\n"
            + "          \"end\": \"2021-08-25T10:14:04.563245234Z\",\n"
            + "          \"eventType\": \"ON_DUTY\",\n"
            + "          \"source\": \"PREDICTION\"\n"
            + "        },\n"
            + "        {\n"
            + "          \"start\": \"2021-08-25T10:14:04.563245234Z\",\n"
            + "          \"end\": \"2021-08-25T16:33:01.563245234Z\",\n"
            + "          \"eventType\": \"DRIVING\",\n"
            + "          \"source\": \"PREDICTION\"\n"
            + "        },\n"
            + "        {\n"
            + "          \"start\": \"2021-08-25T16:33:01.563245234Z\",\n"
            + "          \"end\": \"2021-08-25T18:33:01.563245234Z\",\n"
            + "          \"eventType\": \"OFF_DUTY\",\n"
            + "          \"source\": \"PREDICTION\"\n"
            + "        }\n"
            + "      ],\n"
            + "      \"loads\": [\n"
            + "        {\n"
            + "          \"loadId\": \"6124b2751cc6402c7b8f9708\",\n"
            + "          \"details\": {\n"
            + "            \"start\": \"2021-08-24T13:44:04.563245234Z\",\n"
            + "            \"end\": \"2021-08-25T18:33:01.563245234Z\"\n"
            + "          },\n"
            + "          \"kpis\": {\n"
            + "            \"violations\": 2,\n"
            + "            \"milage\": 787.38,\n"
            + "            \"driveMinutes\": 858.95,\n"
            + "            \"dutyMinutes\": 30.0,\n"
            + "            \"tripMilage\": 787.38,\n"
            + "            \"hos\": {\n"
            + "              \"remainingDuty\": 326.05,\n"
            + "              \"remainingDrive\": 281.05,\n"
            + "              \"remainingWeekly\": 3311.05,\n"
            + "              \"remainingBCP\": 480.0,\n"
            + "              \"cumulativeRest\": 120.0\n"
            + "            },\n"
            + "            \"buffer\": {\n"
            + "              \"initialBuffer\": 0.0\n"
            + "            },\n"
            + "            \"deadhead\": {\n"
            + "              \"estDutyMinutes\": 15.0,\n"
            + "              \"estDriveMinutes\": 0.0,\n"
            + "              \"start\": \"2021-08-24T13:44:04.563245234Z\",\n"
            + "              \"end\": \"2021-08-24T13:59:04.563245234Z\",\n"
            + "              \"milage\": 0.0\n"
            + "            }\n"
            + "          },\n"
            + "          \"type\": \"LOAD\",\n"
            + "          \"stops\": [\n"
            + "            {\n"
            + "              \"stopId\": 1,\n"
            + "              \"details\": {\n"
            + "                \"start\": \"2021-08-24T13:44:04.563245234Z\",\n"
            + "                \"end\": \"2021-08-24T15:59:04.563245234Z\",\n"
            + "                \"routeId\": \"DEFAULT\",\n"
            + "                \"eta\": \"2021-08-24T13:59:04.563245234Z\"\n"
            + "              },\n"
            + "              \"kpis\": {\n"
            + "                \"volutionMinutes\": 17700.066666666666,\n"
            + "                \"earlyVolutionMinutes\": 0.0,\n"
            + "                \"milage\": 0.0,\n"
            + "                \"driveMinutes\": 0.0,\n"
            + "                \"dutyMinutes\": 15.0,\n"
            + "                \"loadMilage\": 0.0,\n"
            + "                \"tripMilage\": 0.0,\n"
            + "                \"hos\": {\n"
            + "                  \"remainingDuty\": 705.0,\n"
            + "                  \"remainingDrive\": 660.0,\n"
            + "                  \"remainingWeekly\": 4185.0,\n"
            + "                  \"remainingBCP\": 480.0,\n"
            + "                  \"cumulativeRest\": 120.0\n"
            + "                },\n"
            + "                \"buffer\": {\n"
            + "                  \"initialBufferMinutes\": 0.0,\n"
            + "                  \"lastBufferMinutes\": 0.0\n"
            + "                },\n"
            + "                \"possibleAppoinmentWindows\": [\n"
            + "                  {\n"
            + "                    \"start\": \"2021-08-24T13:59:04.563245234Z\",\n"
            + "                    \"end\": null\n"
            + "                  }\n"
            + "                ]\n"
            + "              },\n"
            + "              \"type\": \"STOP\",\n"
            + "              \"markers\": null,\n"
            + "              \"timeline\": [\n"
            + "                {\n"
            + "                  \"actionName\": \"DVIR\",\n"
            + "                  \"location\": {\n"
            + "                    \"lat\": 42.0,\n"
            + "                    \"lon\": -88.0\n"
            + "                  },\n"
            + "                  \"locationName\": null,\n"
            + "                  \"locationDetails\": null,\n"
            + "                  \"nextLocation\": {\n"
            + "                    \"lat\": 42.0,\n"
            + "                    \"lon\": -88.0\n"
            + "                  },\n"
            + "                  \"nextLocationName\": null,\n"
            + "                  \"start\": \"2021-08-24T13:44:04.563245234Z\",\n"
            + "                  \"end\": \"2021-08-24T13:59:04.563245234Z\",\n"
            + "                  \"duration\": 15.0,\n"
            + "                  \"hosEventType\": \"ON_DUTY\"\n"
            + "                },\n"
            + "                {\n"
            + "                  \"actionName\": \"APPOINTMENTWORK\",\n"
            + "                  \"location\": {\n"
            + "                    \"lat\": 42.0,\n"
            + "                    \"lon\": -88.0\n"
            + "                  },\n"
            + "                  \"locationName\": \"Appointment Stop 1\",\n"
            + "                  \"locationDetails\": null,\n"
            + "                  \"nextLocation\": {\n"
            + "                    \"lat\": 42.0,\n"
            + "                    \"lon\": -88.0\n"
            + "                  },\n"
            + "                  \"nextLocationName\": \"Appointment Stop 1\",\n"
            + "                  \"start\": \"2021-08-24T13:59:04.563245234Z\",\n"
            + "                  \"end\": \"2021-08-24T15:59:04.563245234Z\",\n"
            + "                  \"duration\": 120.0,\n"
            + "                  \"hosEventType\": \"OFF_DUTY\"\n"
            + "                }\n"
            + "              ]\n"
            + "            },\n"
            + "            {\n"
            + "              \"stopId\": 2,\n"
            + "              \"details\": {\n"
            + "                \"start\": \"2021-08-24T15:59:04.563245234Z\",\n"
            + "                \"end\": \"2021-08-25T18:33:01.563245234Z\",\n"
            + "                \"routeId\": \"DEFAULT\",\n"
            + "                \"eta\": \"2021-08-25T16:33:01.563245234Z\"\n"
            + "              },\n"
            + "              \"kpis\": {\n"
            + "                \"volutionMinutes\": 14673.016666666666,\n"
            + "                \"earlyVolutionMinutes\": 0.0,\n"
            + "                \"milage\": 787.38,\n"
            + "                \"driveMinutes\": 858.95,\n"
            + "                \"dutyMinutes\": 15.0,\n"
            + "                \"loadMilage\": 787.38,\n"
            + "                \"tripMilage\": 787.38,\n"
            + "                \"hos\": {\n"
            + "                  \"remainingDuty\": 326.05,\n"
            + "                  \"remainingDrive\": 281.05,\n"
            + "                  \"remainingWeekly\": 3311.05,\n"
            + "                  \"remainingBCP\": 480.0,\n"
            + "                  \"cumulativeRest\": 120.0\n"
            + "                },\n"
            + "                \"buffer\": {\n"
            + "                  \"initialBufferMinutes\": 0.0,\n"
            + "                  \"lastBufferMinutes\": 0.0\n"
            + "                },\n"
            + "                \"possibleAppoinmentWindows\": [\n"
            + "                  {\n"
            + "                    \"start\": \"2021-08-25T16:33:01.563245234Z\",\n"
            + "                    \"end\": null\n"
            + "                  }\n"
            + "                ]\n"
            + "              },\n"
            + "              \"type\": \"STOP\",\n"
            + "              \"markers\": null,\n"
            + "              \"timeline\": [\n"
            + "                {\n"
            + "                  \"actionName\": \"DRIVE\",\n"
            + "                  \"location\": {\n"
            + "                    \"lat\": 42.0,\n"
            + "                    \"lon\": -88.0\n"
            + "                  },\n"
            + "                  \"locationName\": \"Appointment Stop 1\",\n"
            + "                  \"locationDetails\": null,\n"
            + "                  \"nextLocation\": null,\n"
            + "                  \"nextLocationName\": \"Side Location 12\",\n"
            + "                  \"start\": \"2021-08-24T15:59:04.563245234Z\",\n"
            + "                  \"end\": \"2021-08-24T23:59:04.563245234Z\",\n"
            + "                  \"duration\": 480.0,\n"
            + "                  \"hosEventType\": \"DRIVING\"\n"
            + "                },\n"
            + "                {\n"
            + "                  \"actionName\": \"OFFDUTY\",\n"
            + "                  \"location\": null,\n"
            + "                  \"locationName\": \"Side Location 12\",\n"
            + "                  \"locationDetails\": null,\n"
            + "                  \"nextLocation\": null,\n"
            + "                  \"nextLocationName\": \"Side Location 12\",\n"
            + "                  \"start\": \"2021-08-24T23:59:04.563245234Z\",\n"
            + "                  \"end\": \"2021-08-25T09:59:04.563245234Z\",\n"
            + "                  \"duration\": 600.0,\n"
            + "                  \"hosEventType\": \"OFF_DUTY\"\n"
            + "                },\n"
            + "                {\n"
            + "                  \"actionName\": \"DVIR\",\n"
            + "                  \"location\": null,\n"
            + "                  \"locationName\": \"Side Location 12\",\n"
            + "                  \"locationDetails\": null,\n"
            + "                  \"nextLocation\": null,\n"
            + "                  \"nextLocationName\": \"Side Location 12\",\n"
            + "                  \"start\": \"2021-08-25T09:59:04.563245234Z\",\n"
            + "                  \"end\": \"2021-08-25T10:14:04.563245234Z\",\n"
            + "                  \"duration\": 15.0,\n"
            + "                  \"hosEventType\": \"ON_DUTY\"\n"
            + "                },\n"
            + "                {\n"
            + "                  \"actionName\": \"DRIVE\",\n"
            + "                  \"location\": null,\n"
            + "                  \"locationName\": \"Side Location 12\",\n"
            + "                  \"locationDetails\": null,\n"
            + "                  \"nextLocation\": {\n"
            + "                    \"lat\": 39.952220916748,\n"
            + "                    \"lon\": -75.1641693115234\n"
            + "                  },\n"
            + "                  \"nextLocationName\": \"Appointment Stop 2\",\n"
            + "                  \"start\": \"2021-08-25T10:14:04.563245234Z\",\n"
            + "                  \"end\": \"2021-08-25T16:33:01.563245234Z\",\n"
            + "                  \"duration\": 378.95,\n"
            + "                  \"hosEventType\": \"DRIVING\"\n"
            + "                },\n"
            + "                {\n"
            + "                  \"actionName\": \"APPOINTMENTWORK\",\n"
            + "                  \"location\": {\n"
            + "                    \"lat\": 39.952220916748,\n"
            + "                    \"lon\": -75.1641693115234\n"
            + "                  },\n"
            + "                  \"locationName\": \"Appointment Stop 2\",\n"
            + "                  \"locationDetails\": null,\n"
            + "                  \"nextLocation\": {\n"
            + "                    \"lat\": 39.952220916748,\n"
            + "                    \"lon\": -75.1641693115234\n"
            + "                  },\n"
            + "                  \"nextLocationName\": \"Appointment Stop 2\",\n"
            + "                  \"start\": \"2021-08-25T16:33:01.563245234Z\",\n"
            + "                  \"end\": \"2021-08-25T18:33:01.563245234Z\",\n"
            + "                  \"duration\": 120.0,\n"
            + "                  \"hosEventType\": \"OFF_DUTY\"\n"
            + "                }\n"
            + "              ]\n"
            + "            }\n"
            + "          ],\n"
            + "          \"operationType\": \"SOLO\"\n"
            + "        }\n"
            + "      ]\n"
            + "    }\n"
            + "  ]\n"
            + "}";
}
