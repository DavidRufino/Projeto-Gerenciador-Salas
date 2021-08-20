export interface MessageResponseDTO {
    message: string;
    object: Room;
}

export interface Room {
    id: number;
    name: string;
    date: string,
    startHour: string;
    endHour: string;
    active: boolean;
}
