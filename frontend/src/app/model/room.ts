export class Room {
  id: number;
}

export class Doors {
  frente: boolean;
  esquerda: boolean;
  direita: boolean;
  atras: boolean;
  direcao: string;
}

export enum DoorsPosition {
  FRENTE = 1,
  ESQUERDA = 2,
  DIREITA = 3,
  ATRAS = 4,
}
